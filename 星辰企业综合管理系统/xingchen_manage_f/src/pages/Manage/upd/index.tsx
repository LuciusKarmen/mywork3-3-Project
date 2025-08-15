import React, { useEffect } from 'react';
import {
  Form,
  Input,
  Select,
  Button,
  Space,
  Card,
  DatePicker,
  InputNumber,
} from 'antd';
import dayjs from 'dayjs';

const { Option } = Select;

const layout = {
  labelCol: { span: 6 },
  wrapperCol: { span: 14 },
};

const tailLayout = {
  wrapperCol: { offset: 6, span: 14 },
};

const branches = ['开发部', '设计部', '测试部', '人事部', '财务部', '销售部', '运维部', '产品部', '行政部', '市场部'] as const;

const positions = {
  '开发部': ['前端工程师', '后端工程师', '全栈工程师', '初级前端', 'Java工程师'],
  '设计部': ['UI设计师', '平面设计师', '交互设计师', '插画师'],
  '测试部': ['测试工程师', '自动化测试'],
  '人事部': ['人事专员', '招聘专员'],
  '财务部': ['会计', '财务主管', '财务分析'],
  '销售部': ['销售代表', '销售经理', '销售主管'],
  '运维部': ['系统运维', '运维工程师', '高级运维'],
  '产品部': ['产品经理', '高级产品经理'],
  '行政部': ['行政主管', '行政助理'],
  '市场部': ['市场专员', '市场总监'],
} as const;

type Branch = typeof branches[number];
type Position = (typeof positions)[Branch][number];

// 修改表单数据类型（id 是必须的）
interface UpdateWorkerFormValues {
  id: number;
  name: string;
  phone: string;
  email: string;
  age: number;
  branch: Branch;
  position: Position;
  salary: number;
  date: dayjs.Dayjs;
  status: '有派活' | '无派活';
}

// 模拟获取员工详情的函数（实际项目中应从 API 获取）
const fetchWorkerDetail = (id: number): UpdateWorkerFormValues => {
  // 这里模拟从后端获取数据
  // 实际应使用 API 调用，例如：api.getWorker(id)
  return {
    id: id,
    name: '张三',
    phone: '13800138000',
    email: 'zhangsan@example.com',
    age: 28,
    branch: '开发部',
    position: '前端工程师',
    salary: 15000,
    date: dayjs('2023-05-20'),
    status: '有派活',
  };
};

export const UpdateWorker: React.FC<{ workerId: number }> = ({ workerId }) => {
  const [form] = Form.useForm();

  const onBranchChange = (value: Branch) => {
    const pos = positions[value]?.[0] || '';
    form.setFieldsValue({ position: pos });
  };

  const onFinish = (values: UpdateWorkerFormValues) => {
    const updatedWorker = {
      ...values,
      date: values.date.format('YYYY-MM-DD'),
    };
    console.log('更新员工信息:', updatedWorker);
    // 实际项目中调用 API 更新
    // api.updateWorker(workerId, updatedWorker);
  };

  const onReset = () => {
    form.resetFields();
  };

  // 页面加载时获取员工数据并填充表单
  useEffect(() => {
    const workerData = fetchWorkerDetail(workerId);
    form.setFieldsValue({
      ...workerData,
      date: workerData.date, // dayjs 对象可直接设置
    });
  }, [workerId, form]);

  const currentBranch = form.getFieldValue('branch') as Branch | undefined;
  const currentPositions = currentBranch ? positions[currentBranch] : [];

  return (
    <Card title="修改员工信息" style={{ maxWidth: 780, margin: '40px auto' }}>
      <Form<UpdateWorkerFormValues>
        {...layout}
        form={form}
        name="update-worker-form"
        onFinish={onFinish}
        autoComplete="off"
      >
        {/* 隐藏的 ID 字段 */}
        <Form.Item name="id" hidden>
          <Input />
        </Form.Item>

        <Form.Item name="name" label="姓名" rules={[{ required: true, message: '请输入姓名' }]}>
          <Input />
        </Form.Item>

        <Form.Item name="phone" label="电话" rules={[{ required: true, message: '请输入电话' }]}>
          <Input />
        </Form.Item>

        <Form.Item name="email" label="邮箱" rules={[{ required: true, type: 'email', message: '请输入有效邮箱' }]}>
          <Input />
        </Form.Item>

        <Form.Item name="age" label="年龄" rules={[{ required: true, type: 'number', min: 18, max: 80, message: '年龄应在18-80之间' }]}>
          <InputNumber style={{ width: '100%' }} />
        </Form.Item>

        <Form.Item name="branch" label="部门" rules={[{ required: true, message: '请选择部门' }]}>
          <Select placeholder="选择部门" onChange={onBranchChange}>
            {branches.map((br) => (
              <Option key={br} value={br}>
                {br}
              </Option>
            ))}
          </Select>
        </Form.Item>

        <Form.Item name="position" label="职位" rules={[{ required: true, message: '请选择职位' }]}>
          <Select placeholder="选择职位">
            {currentPositions.map((pos) => (
              <Option key={pos} value={pos}>
                {pos}
              </Option>
            ))}
          </Select>
        </Form.Item>

        <Form.Item name="salary" label="薪资" rules={[{ required: true, type: 'number', min: 0, message: '薪资不能为负' }]}>
          <InputNumber style={{ width: '100%' }} />
        </Form.Item>

        <Form.Item name="date" label="入职时间" rules={[{ required: true, message: '请选择入职时间' }]}>
          <DatePicker format="YYYY-MM-DD" style={{ width: '100%' }} />
        </Form.Item>

        <Form.Item name="status" label="状态" rules={[{ required: true, message: '请选择状态' }]}>
          <Select placeholder="选择状态">
            <Option value="有派活">有派活</Option>
            <Option value="无派活">无派活</Option>
          </Select>
        </Form.Item>

        <Form.Item {...tailLayout}>
          <Space>
            <Button type="primary" htmlType="submit">
              保存修改
            </Button>
            <Button htmlType="button" onClick={onReset}>
              重置
            </Button>
          </Space>
        </Form.Item>
      </Form>
    </Card>
  );
};

// 默认导出，用于路由
const UpdateWorkerPage: React.FC = () => {
  // 假设从 URL 参数获取 workerId，例如 /worker/update/123
  // 实际项目中使用 useSearchParams 或 useParams
  const workerId = 1; // 模拟 ID

  return <UpdateWorker workerId={workerId} />;
};

export default UpdateWorkerPage;
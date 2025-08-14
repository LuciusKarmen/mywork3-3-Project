import React from 'react';
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

// 推导职位联合类型
type Branch = typeof branches[number];
type Position = (typeof positions)[Branch][number];

// 表单数据类型
interface AddWorkerFormValues {
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

export const AddWorker: React.FC = () => {
  const [form] = Form.useForm();

  const onBranchChange = (value: Branch) => {
    const pos = positions[value]?.[0] || '';
    form.setFieldsValue({ position: pos });
  };

  const onFinish = (values: AddWorkerFormValues) => {
    const newWorker = {
      id: Date.now(),
      ...values,
      date: values.date.format('YYYY-MM-DD'),
    };
    console.log('新增员工:', newWorker);
  };

  const onReset = () => {
    form.resetFields();
  };

  // 安全获取当前部门，并推导其职位列表
  const currentBranch = form.getFieldValue('branch') as Branch | undefined;
  const currentPositions = currentBranch ? positions[currentBranch] : [];

  return (
    <Card title="添加员工" style={{ maxWidth: 780, margin: '40px auto', color: '#000000ff' }}>
      <Form<AddWorkerFormValues>
        {...layout}
        form={form}
        name="add-worker-form"
        onFinish={onFinish}
        autoComplete="off"
      >
        <Form.Item name="name" label="姓名" rules={[{ required: true }]}>
          <Input />
        </Form.Item>

        <Form.Item name="phone" label="电话" rules={[{ required: true }]}>
          <Input />
        </Form.Item>

        <Form.Item name="email" label="邮箱" rules={[{ required: true, type: 'email' }]}>
          <Input />
        </Form.Item>

        <Form.Item name="age" label="年龄" rules={[{ required: true, type: 'number', min: 18, max: 80 }]}>
          <InputNumber style={{ width: '100%' }} />
        </Form.Item>

        <Form.Item name="branch" label="部门" rules={[{ required: true }]}>
          <Select placeholder="选择部门" onChange={onBranchChange}>
            {branches.map((br) => (
              <Option key={br} value={br}>
                {br}
              </Option>
            ))}
          </Select>
        </Form.Item>

        <Form.Item name="position" label="职位" rules={[{ required: true }]}>
          <Select placeholder="选择职位">
            {currentPositions.map((pos) => (
              <Option key={pos} value={pos}>
                {pos}
              </Option>
            ))}
          </Select>
        </Form.Item>

        <Form.Item name="salary" label="薪资" rules={[{ required: true, type: 'number', min: 0 }]}>
          <InputNumber style={{ width: '100%' }} />
        </Form.Item>

        <Form.Item name="date" label="入职时间" rules={[{ required: true }]}>
          <DatePicker format="YYYY-MM-DD" style={{ width: '100%' }} />
        </Form.Item>

        <Form.Item name="status" label="状态" rules={[{ required: true }]}>
          <Select placeholder="选择状态">
            <Option value="有派活">有派活</Option>
            <Option value="无派活">无派活</Option>
          </Select>
        </Form.Item>

        <Form.Item {...tailLayout}>
          <Space>
            <Button type="primary" htmlType="submit">
              提交
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

export default AddWorker;
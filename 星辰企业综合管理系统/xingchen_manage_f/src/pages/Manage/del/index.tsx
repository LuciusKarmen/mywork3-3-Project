import React, { useState } from 'react';
import {
  Button,
  Card,
  Table,
  Modal,
  message,
  Typography,
  Tag,
  Input,
  Space,
  Popconfirm,
} from 'antd';
import { SearchOutlined, DeleteOutlined, ExclamationCircleOutlined } from '@ant-design/icons';

const { Title } = Typography;

// 模拟员工数据
const initialWorkers = [
  { id: 1, name: '张三', phone: '13800138000', email: 'zhangsan@example.com', branch: '开发部', position: '前端工程师', status: '有派活', date: '2023-05-20' },
  { id: 2, name: '李四', phone: '13900139000', email: 'lisi@example.com', branch: '设计部', position: 'UI设计师', status: '无派活', date: '2023-06-15' },
  { id: 3, name: '王五', phone: '13700137000', email: 'wangwu@example.com', branch: '销售部', position: '销售代表', status: '有派活', date: '2023-04-10' },
  { id: 4, name: '赵六', phone: '13600136000', email: 'zhaoliu@example.com', branch: '人事部', position: '人事专员', status: '无派活', date: '2023-07-01' },
  { id: 5, name: '钱七', phone: '13500135000', email: 'qianqi@example.com', branch: '财务部', position: '会计', status: '有派活', date: '2023-03-22' },
];

const Del: React.FC = () => {
  const [workers, setWorkers] = useState(initialWorkers);
  const [selectedRowKeys, setSelectedRowKeys] = useState<React.Key[]>([]);
  const [searchText, setSearchText] = useState('');
  const [confirmModal, setConfirmModal] = useState<{ visible: boolean; id: number | null }>({
    visible: false,
    id: null,
  });

  // 搜索过滤
  const filteredWorkers = workers.filter(
    (worker) =>
      worker.name.includes(searchText) ||
      worker.phone.includes(searchText) ||
      worker.email.includes(searchText) ||
      worker.branch.includes(searchText)
  );

  // 删除单个员工
  const handleDelete = (id: number) => {
    setWorkers(workers.filter((worker) => worker.id !== id));
    message.success('员工已删除');
    setConfirmModal({ visible: false, id: null });
  };

  // 批量删除
  const handleBatchDelete = () => {
    if (selectedRowKeys.length === 0) {
      message.warning('请至少选择一个员工');
      return;
    }
    setWorkers(workers.filter((worker) => !selectedRowKeys.includes(worker.id)));
    message.success(`成功删除 ${selectedRowKeys.length} 名员工`);
    setSelectedRowKeys([]);
  };

  const columns = [
    {
      title: '姓名',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: '电话',
      dataIndex: 'phone',
      key: 'phone',
    },
    {
      title: '邮箱',
      dataIndex: 'email',
      key: 'email',
    },
    {
      title: '部门',
      dataIndex: 'branch',
      key: 'branch',
    },
    {
      title: '职位',
      dataIndex: 'position',
      key: 'position',
    },
    {
      title: '入职时间',
      dataIndex: 'date',
      key: 'date',
    },
    {
      title: '状态',
      dataIndex: 'status',
      key: 'status',
      render: (status: string) => (
        <Tag color={status === '有派活' ? 'green' : 'red'}>
          {status}
        </Tag>
      ),
    },
    {
      title: '操作',
      key: 'action',
      render: (_: any, record: any) => (
        <Popconfirm
          title="确定删除该员工吗？"
          onConfirm={() => handleDelete(record.id)}
          okText="删除"
          cancelText="取消"
          icon={<ExclamationCircleOutlined style={{ color: 'red' }} />}
        >
          <Button type="link" danger icon={<DeleteOutlined />}>
            删除
          </Button>
        </Popconfirm>
      ),
    },
  ];

  const rowSelection = {
    selectedRowKeys,
    onChange: (newSelectedRowKeys: React.Key[]) => {
      setSelectedRowKeys(newSelectedRowKeys);
    },
  };

  return (
    <div style={{ padding: '24px', background: '#f5f5f5', minHeight: '100vh' }}>
      <Card 
        title={<Title level={3} style={{ margin: 0 }}>删除员工</Title>} 
        bordered={false}
        style={{ maxWidth: 1200, margin: '0 auto' }}
      >
        <Space direction="vertical" style={{ width: '100%' }}>
          <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
            <Input
              placeholder="搜索员工姓名/电话/邮箱/部门"
              prefix={<SearchOutlined />}
              value={searchText}
              onChange={(e) => setSearchText(e.target.value)}
              style={{ width: 300 }}
            />
            <Popconfirm
              title="确定批量删除选中的员工吗？"
              onConfirm={handleBatchDelete}
              okText="删除"
              cancelText="取消"
              disabled={selectedRowKeys.length === 0}
            >
              <Button 
                danger 
                icon={<DeleteOutlined />} 
                disabled={selectedRowKeys.length === 0}
              >
                批量删除 ({selectedRowKeys.length})
              </Button>
            </Popconfirm>
          </div>

          <Table
            rowSelection={rowSelection}
            columns={columns}
            dataSource={filteredWorkers}
            rowKey="id"
            pagination={{
              pageSize: 10,
              showQuickJumper: true,
              showSizeChanger: true,
            }}
          />
        </Space>
      </Card>

      {/* 确认删除模态框（备用方案，当前用 Popconfirm） */}
      <Modal
        title="确认删除"
        open={confirmModal.visible}
        onOk={() => handleDelete(confirmModal.id!)}
        onCancel={() => setConfirmModal({ visible: false, id: null })}
        okText="删除"
        cancelText="取消"
        okButtonProps={{ danger: true }}
      >
        <p>确定要删除员工 "<strong>{workers.find(w => w.id === confirmModal.id)?.name}</strong>" 吗？</p>
        <p style={{ color: 'red' }}>此操作不可撤销！</p>
      </Modal>
    </div>
  );
};

export default Del;
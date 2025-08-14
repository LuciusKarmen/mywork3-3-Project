import React from 'react';
import { Table, Tag, Typography, Space, Button } from 'antd';
import type { TableProps } from 'antd';
import { workers } from '../../types/worker'; 
import type { Worker } from '../../types/worker';
import './index.scss'; // 可共用样式

const { Text } = Typography;

type WorkerTableType = Worker;

const List: React.FC = () => {
  const statusColorMap: Record<WorkerTableType['status'], string> = {
    '有派活': 'success',
    '无派活': 'default',
  };

  const columns: TableProps<WorkerTableType>['columns'] = [
    {
      title: '姓名',
      dataIndex: 'name',
      key: 'name',
      fixed: 'left',
      width: 100,
      render: (text) => <strong style={{ color: '#5bc3ffff' }}>{text}</strong>,
    },
    {
      title: '电话',
      dataIndex: 'phone',
      key: 'phone',
      width: 130,
    },
    {
      title: '邮箱',
      dataIndex: 'email',
      key: 'email',
      width: 180,
      render: (text) => <Text copyable>{text}</Text>, // 可复制
    },
    {
      title: '年龄',
      dataIndex: 'age',
      key: 'age',
      width: 80,
      render: (text) => <div style={{ color: '#535353ff' }}>{text}</div>,
    },
    {
      title: '所属部门',
      dataIndex: 'branch',
      key: 'branch',
      width: 120,
      render: (text) => (
        <Tag color="blue" style={{ fontSize: '12px' }}>
          {text}
        </Tag>
      ),
    },
    {
      title: '职位',
      dataIndex: 'position',
      key: 'position',
      width: 140,
    },
    {
      title: '薪资',
      dataIndex: 'salary',
      key: 'salary',
      width: 100,
      sorter: (a, b) => a.salary - b.salary,
      render: (salary) => (
        <span style={{ color: '#cf9e24' }}>
          ¥{salary.toLocaleString()}
        </span>
      ),
    },
    {
      title: '入职时间',
      dataIndex: 'date',
      key: 'date',
      width: 120,
      sorter: (a, b) => new Date(a.date).getTime() - new Date(b.date).getTime(),
    },
    {
      title: '状态',
      dataIndex: 'status',
      key: 'status',
      width: 100,
      filters: [
        { text: '有派活', value: '有派活' },
        { text: '无派活', value: '无派活' },
      ],
      onFilter: (value, record) => record.status === value,
      render: (status) => (
        <Tag color={statusColorMap[status]}>
          {status}
        </Tag>
      ),
    },
    {
      title: '操作',
      key: 'action',
      width: 150,
      fixed: 'right',
      render: (_, record) => (
        <Space size="middle">
          <a>查看</a>
          <a>编辑</a>
          <a style={{ color: 'red' }}>删除</a>
        </Space>
      ),
    },
  ];

  return (
    <div className="worker-list">
      <div className="worker-list-header" style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 16 }}>
        <h2>员工列表</h2>
        <Button type="primary">添加新员工</Button>
      </div>
      <Table<WorkerTableType>
        columns={columns}
        dataSource={workers}
        rowKey="id"
        bordered
        scroll={{ x: 'max-content' }}
        pagination={{ pageSize: 10 }}
      />
    </div>
  );
};

export default List;
import React from 'react';
import { Table, Space, Tag, Typography,Button } from 'antd';
import type { TableProps } from 'antd';
import { branches} from '../../types/branch'; 
import type { Branch as BranchType } from '../../types/branch';
import './index.scss'


const { Text } = Typography;

//万能的表格设置
type TableDataType = BranchType;

const Branch: React.FC = () => {

  const columns: TableProps<TableDataType>['columns'] = [
    {
      title: '部门名称',
      dataIndex: 'name',
      key: 'name',
      render: (text) => <strong style={{color:"#22a7f5ff"}}>{text}</strong>,
      width: 150,
    },
    {
      title: '部门经理',
      dataIndex: 'manager',
      key: 'manager',
      width: 120,
      render: (text) => <div style={{color:"#5bc3ffff"}}>{text}</div>,
    },
    {
      title: '部门电话',
      dataIndex: 'phone',
      key: 'phone',
      width: 140,
    },
    {
      title: '部门邮箱',
      dataIndex: 'email',
      key: 'email',
      render: (text) => <Text copyable>{text}</Text>, // 可复制邮箱
      width: 180,
    },
    {
      title: '人数',
      dataIndex: 'number',
      key: 'number',
      render: (num) => (
        <Tag color={num > 0 ? 'processing' : 'default'}>
          {num} 人
        </Tag>
      ),
      width: 100,
    },
    {
      title: '上级部门',
      dataIndex: 'top',
      key: 'top',
      width: 120,
    },
    {
      title: '成立时间',
      dataIndex: 'date',
      key: 'date',
      width: 120,
    },
    {
      title: '操作',
      key: 'action',
      render: (_, record) => (
        <Space size="middle">
          <a>查看</a>
          <a>编辑</a>
          <a style={{ color: 'red' }}>删除</a>
        </Space>
      ),
      width: 150,
    },
  ];

  return (
    <div className="branch">
      <div className='branch-title'>
      <h2 style={{color:"#242424ff"}}>部门管理</h2>
      <Button type="primary">添加新部门</Button>
      </div>
      <Table<TableDataType>
        columns={columns}
        dataSource={branches}
        rowKey="id" 
        pagination={{ pageSize: 10 }}
        scroll={{ x: 'max-content' }}
        bordered
      />
    </div>
  );
};

export default Branch;
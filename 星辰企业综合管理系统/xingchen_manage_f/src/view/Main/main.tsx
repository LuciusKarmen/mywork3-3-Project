import './index.scss';
import {
  HomeFilled,
  DatabaseFilled,
  SettingFilled,
  GoldFilled,
  UserOutlined,
  UserAddOutlined,
  UserSwitchOutlined,
  UserDeleteOutlined,
  ArrowLeftOutlined,
  MenuUnfoldOutlined,
} from '@ant-design/icons';
import { useNavigate, Outlet, useLocation } from 'react-router-dom'; 
import { useState, useEffect } from 'react';
import { Menu } from 'antd';

function Main() {
  const navigate = useNavigate();
  const location = useLocation();


  const [selectedKeys, setSelectedKeys] = useState([location.pathname]);


  useEffect(() => {
    setSelectedKeys([location.pathname]);
  }, [location.pathname]);

  const menuItems = [
    {
      key: '/main',
      icon: <HomeFilled />,
      label: '首页'
    },
    {
      key: '/main/branch',
      icon: <GoldFilled />,
      label: '部门管理'
    },
    {
      key: '/main/list',
      icon: <DatabaseFilled />,
      label: '员工列表'
    },
    {
      key: 'sub1',
      icon: <UserOutlined />,
      label: '员工管理',
      children: [
        {
          key: '/main/manage/add',
          icon: <UserAddOutlined />,
          label: '员工添加'
        },
        {
          key: '/main/manage/update',
          icon: <UserSwitchOutlined />,
          label: '员工修改'
        },
        {
          key: '/main/manage/delete',
          icon: <UserDeleteOutlined />,
          label: '员工删除'
        }
      ]
    },
    {
      key: '/main/setting',
      icon: <SettingFilled />,
      label: '设置'
    }
  ];

  const handleMenuClick = ({ key }: { key: string }) => {
    if (key.startsWith('/')) {
      navigate(key);
    }
  };

  const handleLogout = () => {
    navigate('/login');
  };

  return (
    <div className="App">
      <div className="tit">
        <div className="tl">
          <MenuUnfoldOutlined /> 星辰管理系统
        </div>
        <div className="tr">用户信息</div>
      </div>

      <div className="sidebar">
        <Menu
          className="menu"
          mode="inline"
          theme="dark"
          items={menuItems}
          onClick={handleMenuClick}
          selectedKeys={selectedKeys} 
        />
        <div className="leave" onClick={handleLogout}>
          <ArrowLeftOutlined /> 退出
        </div>
      </div>

      <div className="content">
        <div className="content-text">
          <Outlet />
        </div>
      </div>
    </div>
  );
}

export default Main;
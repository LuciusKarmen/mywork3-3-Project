// view/Main.tsx
import './index.scss';
import { Menu } from 'antd';
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
import type { JSX } from 'react/jsx-runtime';

const getItem = (label: string, key: string, icon: JSX.Element, children: { key: any; icon: any; children: any; label: any; }[] | undefined) => ({
  key,
  icon,
  children,
  label,
});

function Main() {
  const navigate = useNavigate();
  const location = useLocation(); // 获取当前路径

  // 根据当前路径设置默认选中的菜单项
  const [selectedKeys, setSelectedKeys] = useState([location.pathname]);

  // 当路由变化时，更新 selectedKeys
  useEffect(() => {
    setSelectedKeys([location.pathname]);
  }, [location.pathname]);

  const menuItems = [
    getItem('首页', '/main', <HomeFilled />),
    getItem('部门管理', '/main/branch', <GoldFilled />),
    getItem('员工列表', '/main/list', <DatabaseFilled />),
    getItem(
      '员工管理',
      'sub1',
      <UserOutlined />,
      [
        getItem('员工添加', '/main/manage/add', <UserAddOutlined />),
        getItem('员工修改', '/main/manage/update', <UserSwitchOutlined />),
        getItem('员工删除', '/main/manage/delete', <UserDeleteOutlined />)
      ]
    ),
    getItem('设置', '/main/setting', <SettingFilled />)
  ];

  const handleMenuClick = ({ key }) => {
    if (key.startsWith('/')) {
      navigate(key);
    }
  };

  const handleLogout = () => {
    navigate('/login');
  };

  return (
    <div className="App">
      <div className="title">
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
        
        <div className="content-text"><Outlet /></div>
        
      </div>
    </div>
  );
}

export default Main;
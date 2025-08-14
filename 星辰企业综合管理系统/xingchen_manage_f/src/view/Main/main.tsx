import './index.scss'
import { Menu } from 'antd';
import { HomeFilled ,DatabaseFilled,SettingFilled,
  GoldFilled,UserOutlined,UserSwitchOutlined,UserAddOutlined,
  UserDeleteOutlined,ArrowLeftOutlined,MenuUnfoldOutlined } from '@ant-design/icons';

const { SubMenu } = Menu;
function Main() {
  return (
    <div className="App"> 
     <div className="title">
      <div className='tl'><MenuUnfoldOutlined />星辰管理系统</div>
      <div className='tr'>用户信息<img src='1' alt="logo" /><img/></div>
     </div>
     <div className="sidebar">
              <Menu
        className='menu'
        defaultSelectedKeys={['1']}
        defaultOpenKeys={['sub1']}
        mode="inline"
        theme="dark"

      >
          <Menu.Item key="1" className='menu-item' icon={<HomeFilled />}>首页</Menu.Item>
          <Menu.Item key="2" className='menu-item' icon={<GoldFilled />}> 部门管理</Menu.Item>
          <Menu.Item key="3" className='menu-item' icon={<DatabaseFilled/>}>员工列表</Menu.Item>
          <SubMenu key="sub1" title="员工管理" icon={<UserOutlined />}>
            <Menu.Item key="6"  className='menu-item' icon={<UserAddOutlined />}>员工添加</Menu.Item>
            <Menu.Item key="7"  className='menu-item' icon={<UserSwitchOutlined />}>员工修改</Menu.Item>
            <Menu.Item key="8"  className='menu-item' icon={<UserDeleteOutlined />}>员工删除</Menu.Item>
          </SubMenu>
          <Menu.Item key="4" className='menu-item' icon={<SettingFilled />}> 设置</Menu.Item>
      </Menu>
      <div className='leave'><ArrowLeftOutlined />退出</div>
     </div>
     <div className="content">11erg1</div>
    </div>
  );
}

export default Main;
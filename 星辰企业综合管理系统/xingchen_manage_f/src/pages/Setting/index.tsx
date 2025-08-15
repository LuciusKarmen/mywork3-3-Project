import React, { useState } from 'react';
import {
  Button,
  Card,
  Divider,
  Form,
  Input,
  Select,
  Switch,
  Typography,
  message,
  Avatar,
  Upload,
  Modal,
} from 'antd';
import { useNavigate } from 'react-router-dom';
import { UserOutlined, UploadOutlined, SaveOutlined, LogoutOutlined } from '@ant-design/icons';

const { Title, Text } = Typography;
const { Option } = Select;

const initialUserInfo = {
  username: '许光明',
  nickname: '超级管理员',
  email: 'admin@company.com',
  phone: '13800138000',
  department: '技术部',
  jobTitle: '高级工程师',
  theme: 'light',
  notifications: true,
  autoSave: true,
};

const Setting: React.FC = () => {
  const navigate = useNavigate();
  const [form] = Form.useForm();
  const [loading, setLoading] = useState(false);
  const [avatarUrl, setAvatarUrl] = useState<string | null>(null);
  const [isModalVisible, setIsModalVisible] = useState(false);

  React.useEffect(() => {
    form.setFieldsValue(initialUserInfo);
  }, [form]);

  const handleAbout = () => {
    navigate('/our');
  };

  const handleLogout = () => {
    setIsModalVisible(true);
  };

  const confirmLogout = () => {
    message.success('已退出登录');
    navigate('/login');
    setIsModalVisible(false);
  };

  const cancelLogout = () => {
    setIsModalVisible(false);
  };

  const onFinish = (values: any) => {
    setLoading(true);
    setTimeout(() => {
      console.log('保存设置:', values);
      message.success('设置保存成功！');
      setLoading(false);
    }, 800);
  };

  const beforeUpload = (file: File) => {
    const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png';
    if (!isJpgOrPng) {
      message.error('只能上传 JPG/PNG 文件!');
    }
    const isLt2M = file.size / 1024 / 1024 < 2;
    if (!isLt2M) {
      message.error('图片必须小于 2MB!');
    }
    return isJpgOrPng && isLt2M;
  };

  const handleUpload = (info: any) => {
    if (info.file.status === 'done') {
      const url = info.file.response?.url || URL.createObjectURL(info.file.originFileObj);
      setAvatarUrl(url);
      message.success(`${info.file.name} 上传成功`);
    } else if (info.file.status === 'error') {
      message.error(`${info.file.name} 上传失败`);
    }
  };

  return (
    <div className="setting" style={{ padding: '24px', background: '#f5f5f5', minHeight: '100vh' }}>
      <Card 
        title={<Title level={3} style={{ margin: 0 }}>系统设置</Title>} 
        bordered={false}
        style={{ maxWidth: 800, margin: '0 auto' }}
      >
        <Form form={form} layout="vertical" onFinish={onFinish}>
          <Form.Item label="头像">
            <div style={{ display: 'flex', alignItems: 'center', gap: '24px' }}>
              <Avatar size={80} icon={<UserOutlined />} src={avatarUrl} />
              <Upload
                name="avatar"
                listType="picture-card"
                className="avatar-uploader"
                showUploadList={false}
                action="/api/upload"
                beforeUpload={beforeUpload}
                onChange={handleUpload}
              >
                <Button icon={<UploadOutlined />}>上传新头像</Button>
              </Upload>
            </div>
          </Form.Item>

          <Divider />

          <Title level={4}>基本信息</Title>
          <Form.Item name="username" label="用户名" rules={[{ required: true }]}>
            <Input disabled placeholder="用户名不可修改" />
          </Form.Item>

          <Form.Item name="nickname" label="昵称" rules={[{ required: true }]}>
            <Input placeholder="请输入昵称" />
          </Form.Item>

          <Form.Item name="email" label="邮箱" rules={[{ required: true, type: 'email' }]}>
            <Input placeholder="请输入邮箱" />
          </Form.Item>

          <Form.Item name="phone" label="手机号" rules={[{ required: true }]}>
            <Input placeholder="请输入手机号" />
          </Form.Item>

          <Form.Item name="department" label="部门">
            <Input placeholder="请输入部门" />
          </Form.Item>

          <Form.Item name="jobTitle" label="职位">
            <Input placeholder="请输入职位" />
          </Form.Item>

          <Divider />

          <Title level={4}>偏好设置</Title>
          <Form.Item name="theme" label="界面主题">
            <Select>
              <Option value="light">浅色主题</Option>
              <Option value="dark">深色主题</Option>
            </Select>
          </Form.Item>

          <Form.Item name="notifications" label="消息通知" valuePropName="checked">
            <Switch />
            <Text type="secondary" style={{ marginLeft: 8 }}>开启系统消息提醒</Text>
          </Form.Item>

          <Form.Item name="autoSave" label="自动保存" valuePropName="checked">
            <Switch />
            <Text type="secondary" style={{ marginLeft: 8 }}>表单内容自动保存</Text>
          </Form.Item>

          <Divider />

          <Form.Item>
            <div style={{ display: 'flex', justifyContent: 'space-between', marginTop: 24 }}>

                <Button type="primary" htmlType="submit" loading={loading} icon={<SaveOutlined />}>
                  保存设置
                </Button>
                <Button onClick={handleAbout}>关于我们</Button>
              <Button danger icon={<LogoutOutlined />} onClick={handleLogout}>
                退出登录
              </Button>
            </div>
          </Form.Item>
        </Form>
      </Card>
      <Modal
        title="确认退出"
        open={isModalVisible}
        onOk={confirmLogout}
        onCancel={cancelLogout}
        okText="退出"
        cancelText="取消"
      >
        <p>确定要退出登录吗？</p>
      </Modal>
    </div>
  );
};

export default Setting;
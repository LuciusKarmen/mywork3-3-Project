
import './index.scss';
import soulSoother from '../../types/dao/soul'; // 引入你的鸡汤数组
import { useEffect, useState } from 'react';
import { Card, Typography, Avatar, Space, Row, Col } from 'antd';
import { UserOutlined, SmileOutlined } from '@ant-design/icons';

const { Title, Text } = Typography;

function Home() {
  const [randomSoul, setRandomSoul] = useState('');
  const [greeting, setGreeting] = useState('');
  const username = localStorage.getItem('username') || '用户';

  // 生成问候语
  const getGreeting = () => {
    const hour = new Date().getHours();
    if (hour < 6) return '凌晨好';
    if (hour < 12) return '早上好';
    if (hour < 14) return '中午好';
    if (hour < 18) return '下午好';
    return '晚上好';
  };

  // 随机选择一条心灵鸡汤
  const getRandomSoul = () => {
    return soulSoother[Math.floor(Math.random() * soulSoother.length)];
  };

  useEffect(() => {
    setGreeting(getGreeting());
    setRandomSoul(getRandomSoul());

    // 每2小时更换一次心灵鸡汤
    const interval = setInterval(() => {
      setRandomSoul(getRandomSoul());
    }, 2 * 60 * 60 * 1000);

    return () => clearInterval(interval);
  }, []);

  return (
    <div className="Home">
      <Row gutter={[24, 24]} style={{ width: '100%' }}>
        <Col xs={24} lg={16}>
          <Card 
            className="welcome-card"
            bordered={false}
            style={{ 
              height: '100%',
              background: 'linear-gradient(135deg, #667eea 0%, #764ba2 25%, #667eea 100%)',
              borderRadius: '16px',
              overflow: 'hidden',
              position: 'relative'
            }}
          >
            <div className="info">
              <div className="greeting">
                <Title 
                  level={2} 
                  style={{ 
                    color: '#fff', 
                    margin: 0,
                    textShadow: '2px 2px 4px rgba(0,0,0,0.3)'
                  }}
                >
                  {greeting}，{username}！
                </Title>
                <Text 
                  style={{ 
                    color: 'rgba(255,255,255,0.9)',
                    fontSize: '16px'
                  }}
                >
                  欢迎回到星辰管理系统
                </Text>
              </div>
              
              <div className="user-info">
                <Avatar 
                  size={80} 
                  icon={<UserOutlined />} 
                  src={localStorage.getItem('avatar') || ''} 
                  style={{ 
                    border: '3px solid rgba(255,255,255,0.3)',
                    boxShadow: '0 4px 8px rgba(0,0,0,0.2)'
                  }}
                />
              </div>
            </div>

            <div className="soul-container">
              <Card 
                className="soul-card"
                style={{ 
                  background: 'rgba(255,255,255,0.15)',
                  backdropFilter: 'blur(10px)',
                  border: '1px solid rgba(255,255,255,0.2)',
                  borderRadius: '12px',
                  textAlign: 'center',
                  margin: '20px 0'
                }}
              >
                <SmileOutlined style={{ fontSize: '24px', color: '#fff', marginBottom: '12px' }} />
                <Text 
                  strong 
                  style={{ 
                    color: '#fff', 
                    fontSize: '18px',
                    lineHeight: 1.6
                  }}
                >
                  {randomSoul}
                </Text>
              </Card>
            </div>
          </Card>
        </Col>

        <Col xs={24} lg={8}>
          <Card 
            title="系统概览" 
            bordered={false}
            style={{ 
              height: '100%',
              borderRadius: '16px',
              boxShadow: '0 8px 32px rgba(0,0,0,0.1)',
              border: '1px solid rgba(0,0,0,0.1)'
            }}
          >
            <Space direction="vertical" size="large" style={{ width: '100%' }}>
              <div className="stat-item">
                <Text strong>今日任务</Text>
                <Title level={3} style={{ margin: 0, color: '#1890ff' }}>3/5</Title>
              </div>
              
              <div className="stat-item">
                <Text strong>待办事项</Text>
                <Title level={3} style={{ margin: 0, color: '#52c41a' }}>2</Title>
              </div>
              
              <div className="stat-item">
                <Text strong>消息通知</Text>
                <Title level={3} style={{ margin: 0, color: '#faad14' }}>1</Title>
              </div>
            </Space>
          </Card>
        </Col>
      </Row>

      {/* 装饰性元素 */}
      <div className="decorative-elements">
        <div className="circle circle-1"></div>
        <div className="circle circle-2"></div>
        <div className="circle circle-3"></div>
      </div>
    </div>
  );
}

export default Home;


import { useRef, useEffect, useState } from 'react';
import './index.scss';
import { useNavigate } from 'react-router-dom';
import { Button, Input, Form, message } from 'antd';
import { UserOutlined, LockOutlined } from '@ant-design/icons';

function Login() {
  const canvasRef = useRef<HTMLCanvasElement>(null);
  const navigate = useNavigate();
  const [form] = Form.useForm();
  const [loading, setLoading] = useState(false);

  const config = {
    number: 80,
    color: '#04c8c4',
    opacity: 0.6,
    size: 2,
    lineColor: '#9fff',
    lineOpacity: 0.3,
    lineWidth: 1,
    linkDistance: 150,
    velocity: 1.0,
  };

  const particles: Array<{
    x: number;
    y: number;
    vx: number;
    vy: number;
  }> = [];

  const initParticles = () => {
    const canvas = canvasRef.current;
    if (!canvas) return;

    const ctx = canvas.getContext('2d');
    if (!ctx) return;

    const resize = () => {
      const mainElement = document.querySelector('.main');
      if (mainElement && canvas) {
        canvas.width = mainElement.clientWidth;
        canvas.height = mainElement.clientHeight;
      }
    };

    const initializeParticles = () => {
      const mainElement = document.querySelector('.main');
      if (!mainElement) return;
      const width = mainElement.clientWidth;
      const height = mainElement.clientHeight;

      for (let i = 0; i < config.number; i++) {
        particles.push({
          x: Math.random() * width,
          y: Math.random() * height,
          vx: (Math.random() - 0.5) * config.velocity,
          vy: (Math.random() - 0.5) * config.velocity,
        });
      }
    };

    const draw = () => {
      if (!ctx || !canvas) return;

      ctx.clearRect(0, 0, canvas.width, canvas.height);
      ctx.fillStyle = config.color;
      ctx.globalAlpha = config.opacity;

      for (const p of particles) {
        ctx.beginPath();
        ctx.arc(p.x, p.y, config.size, 0, Math.PI * 2);
        ctx.fill();

        p.x += p.vx;
        p.y += p.vy;

        if (p.x <= 0 || p.x >= canvas.width) p.vx *= -1;
        if (p.y <= 0 || p.y >= canvas.height) p.vy *= -1;
      }

      for (let i = 0; i < particles.length; i++) {
        for (let j = i + 1; j < particles.length; j++) {
          const dx = particles[i].x - particles[j].x;
          const dy = particles[i].y - particles[j].y;
          const dist = Math.sqrt(dx * dx + dy * dy);

          if (dist < config.linkDistance) {
            ctx.strokeStyle = config.lineColor;
            ctx.globalAlpha = config.lineOpacity;
            ctx.beginPath();
            ctx.moveTo(particles[i].x, particles[i].y);
            ctx.lineTo(particles[j].x, particles[j].y);
            ctx.stroke();
          }
        }
      }

      requestAnimationFrame(draw);
    };

    window.addEventListener('resize', resize);
    resize();
    initializeParticles();
    draw();

    return () => {
      window.removeEventListener('resize', resize);
    };
  };

  useEffect(() => {
    const cleanup = initParticles();
    return () => {
      if (cleanup && typeof cleanup === 'function') {
        cleanup();
      }
    };
  }, []);

  const handleLogin = async () => {
    setLoading(true);
    try {
      // 模拟登录请求
      await new Promise(resolve => setTimeout(resolve, 1500));
      
      // 登录成功
      message.success('登录成功！');
      navigate('/main');
    } catch (error) {
      message.error('登录失败，请检查用户名和密码');
    } finally {
      setLoading(false);
    }
  };

  const handleShow = () => {
    navigate('/our');
  };

  return (
    <div className="login">
      <div className="pic">
        <img src="/1687678759422461.png" alt="Background" className="i"/>
      </div>
      <div className="main">
        <canvas ref={canvasRef} className="particles-canvas"/>
        <div className='form'>
            <div className='title1'>欢迎使用</div>
            <div className='title2'>---星辰管理系统</div>
            <Form 
              form={form} 
              layout="vertical" 
              onFinish={handleLogin}
              requiredMark={false}
            >
              <Form.Item
                name="username"
                rules={[{ required: true, message: '请输入用户名!' }]}
              >
                <Input 
                  size="large" 
                  placeholder="用户名" 
                  prefix={<UserOutlined />}
                />
              </Form.Item>

              <Form.Item
                name="password"
                rules={[{ required: true, message: '请输入密码!' }]}
              >
                <Input.Password 
                  size="large" 
                  placeholder="密码" 
                  prefix={<LockOutlined />}
                />
              </Form.Item>

              <div className='btn'>
                <Button 
                  className='reg' 
                  size="large"
                  onClick={() => message.info('注册功能暂未开放')}
                >
                  注册
                </Button>
                <Button 
                  type="primary" 
                  htmlType="submit" 
                  className='enter' 
                  size="large"
                  loading={loading}
                >
                  登录
                </Button>
              </div>
            </Form>
        </div>
        <div className="footer" onClick={handleShow}>
          StellarNet Studio
        </div>
      </div>
    </div>
  );
}

export default Login;

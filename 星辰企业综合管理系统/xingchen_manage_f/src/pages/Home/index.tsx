import './index.scss';
import soulSoother from '../../types/dao/soul'; // 引入你的鸡汤数组

function Home() {
  // 随机选择一条心灵鸡汤
  const randomSoul = soulSoother[Math.floor(Math.random() * soulSoother.length)];

  return (
    <div className="Home">
      <div className="info">
        <div className="pic">
          <img src="" alt="头像" />
        </div>
        <div className="name">{localStorage.getItem('username')}</div>
        <div className="soul">{randomSoul}</div>
      </div>
    </div>
  );
}

export default Home;
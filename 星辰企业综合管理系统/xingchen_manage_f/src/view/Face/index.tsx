import './index.scss'
import { useNavigate } from 'react-router-dom';
function Face(){
    const navigate = useNavigate();
    const a = () => {
        navigate('/login');
    }

    return (
        <section className="welcome">
            <header className="title">欢迎体验 星辰企业管理系统</header>
            <article className="subtitle">高效协同 · 精细管理 · 智能决策</article>
            <button className="enter" onClick={a}>立即体验</button>
        </section>
    )
}

export default Face;
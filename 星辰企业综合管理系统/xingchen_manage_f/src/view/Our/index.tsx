import './index.scss'
function Our(){
    return (
    <div className="about-container">
    <div className="overlay"></div>
    <div className="content">
      <h1>欢迎来到星辰网络工作室</h1>
      <p>
        这是一支专注于互联网开发与数字创新的年轻团队，致力于打造高质量的 Web
        应用、小程序、企业级解决方案，并积极探索人工智能技术的应用与落地。
      </p>

      <h2>我们的优势</h2>
      <ul>
        <li>✅ 前端设计：响应式网站、Vue/React 框架精通</li>
        <li>✅ 后端开发：Node.js、Spring Boot</li>
        <li>✅ 移动开发：微信小程序、App 开发</li>
        <li>✅ 人工智能：Spring AI、项目智能化改造</li>
        <li>✅ 技术支持：7×24 小时在线服务，全程技术指导</li>
      </ul>

      <h2>本工作室的愿景<span style={{color:"red"}}>&#10084;</span></h2>
      <p>以技术为基石，以用户体验为核心，助力企业实现数字化转型，让科技点亮未来。</p>

      <div className="contact">
        <p>📧 邮箱：karmenluious@gmail.com</p>
        <p>📞 电话：+86 183-2918-3547</p>
        <p>📍 地址：中国 · 杭州市西湖区</p>
        <a href="http://xingchengnet.online:8889">详情请跳转至官方网站</a>
      </div>
    </div>
    </div>
    )
}
export default Our;
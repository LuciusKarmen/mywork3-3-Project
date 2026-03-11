<template>
  <div class="main">
    <div class="centre">
      <div class="rules-container">
        <h1 class="title">✨ 星辰学院学生行为准则</h1>
        <p class="motto">仰望星空，脚踏实地；修身立德，知行合一。</p>

        <ol class="rules-list">
          <li>
            <strong>尊师重道，团结友爱</strong><br />
            尊敬师长，虚心求教；友爱同学，互助共进；杜绝欺凌，反对歧视。
          </li>
          <li>
            <strong>诚实守信，严于律己</strong><br />
            考试不作弊，作业不抄袭；言行一致，信守承诺；爱护公物，节约资源。
          </li>
          <li>
            <strong>勤学笃行，追求卓越</strong><br />
            按时上课，专注听讲；主动探索，勇于创新；崇尚科学，明辨是非。
          </li>
          <li>
            <strong>文明言行，涵养品格</strong><br />
            着装整洁，举止得体；使用文明用语，拒绝网络暴力；遵守公共秩序，维护校园环境。
          </li>
        </ol>

        <p class="footer">
          凡星辰学子，当以德立身，以学报国。<br />
          违反本准则者，将依校规处理；表现突出者，予以表彰嘉奖。
        </p>
        <p class="signature">—— 星辰学院 学生发展中心<br />2026年3月</p>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup name="">
// 无需逻辑，纯展示页面
</script>

<style lang="scss" scoped>
.main {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background: linear-gradient(135deg, rgb(224, 249, 255), rgb(241, 241, 241));
  background-size: 400% 400%;
  flex-direction: column;
  animation: gradientBG 15s ease infinite;
  overflow: hidden;
}

@keyframes gradientBG {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}

.centre {
  width: 90%;
  height: 90%;
  background-color: rgb(255, 255, 255);
  border-radius: 16px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 30px;
  box-sizing: border-box;
}

.rules-container {
  width: 100%;
  max-width: 800px;
  text-align: left;
  color: #333;
  font-family: 'Microsoft YaHei', 'PingFang SC', sans-serif;
  line-height: 1.7;
  overflow-y: auto;
  padding-right: 10px;

  .title {
    text-align: center;
    color: #1a73e8;
    margin-bottom: 16px;
    font-size: 28px;
  }

  .motto {
    text-align: center;
    font-style: italic;
    color: #555;
    margin-bottom: 24px;
    font-size: 18px;
  }

  .rules-list {
    padding-left: 20px;
    margin: 20px 0;

    li {
      margin-bottom: 18px;
      font-size: 16px;

      strong {
        color: #1a73e8;
        display: block;
        margin-bottom: 1px;
      }
    }
  }

  .footer {
    margin-top: 24px;
    font-weight: bold;
    color: #444;
    text-align: center;
  }

  .signature {
    text-align: right;
    color: #777;
    margin-top: 20px;
    font-style: italic;
  }
}
</style>

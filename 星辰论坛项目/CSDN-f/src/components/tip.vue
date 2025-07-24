<template>
  <div class="t1" @click="preview">
    <div class="t2">
      <div class="tp"><img :src="picture" alt="1" class="ti" /></div>
      <div class="content">
        <div class="tt1">
          <div>
            <div class="tn">{{ tip.tuser }}</div>
          </div>
          <div class="tt2">
            <div class="tt">{{ tip.ttime }}</div>
            <div class="tt">{{ tip.tclass }}</div>
          </div>
        </div>
        <div class="tc">{{ tip.tname }}</div>
      </div>
    </div>

    <div class="foot">
      <div class="tg">点赞:{{ tip.tgood }}<Heart class="tc"></Heart></div>
      <div>评论:{{ tip.tmessage }}<Comment class="tc"></Comment></div>
    </div>
  </div>
</template>

<script setup lang="ts" name="Tipcomponent">
import { Heart, Comment } from '@nutui/icons-vue'
import { useRouter } from 'vue-router'
import { ref, reactive, toRefs, watch, onMounted, computed } from 'vue'
import { type Tip } from '../api/tip'
import { getPic } from '../api/login'
import type { User } from '../api/user'

const router = useRouter()
const props = defineProps<{
  tip: Tip
}>()
const ok = ref(false)

const preview = async () => {
  await router.push('/pre/' + props.tip.tid)
}
const OK = () => {
  ok.value = !ok.value
}
const pic = ref<User>()
const Picture = async (name: string) => {
  getPic(name).then((res: User | null) => {
    if (res !== null) {
      pic.value = res
    }
  })
}
const picture = computed(() => {
  return `http://localhost:8080/${pic.value?.pic}`
})
watch(
  () => props.tip,
  () => {
    console.log(props.tip)
  },
)
onMounted(() => {
  console.log(props.tip)
  Picture(props.tip.tuser)
})
</script>

<style scoped lang="scss">
.t1 {
  border: 1px solid #e0e0e0;
  width: 76%;
  height: 25vh;
  margin: auto;
  border-radius: 12px;
  padding: 16px;
  background-color: rgba(255, 255, 255, 0.9);
  backdrop-filter: blur(10px);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  position: relative;
  transition:
    transform 0.2s ease,
    box-shadow 0.2s ease;
  cursor: pointer;

  &:hover {
    transform: translateY(-4px);
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
  }

  .t2 {
    display: flex;
    align-items: center;
    margin-bottom: 12px;

    .tp {
      width: 40px;
      height: 40px;
      border-radius: 50%;
      overflow: hidden;
      flex-shrink: 0;

      .ti {
        width: 100%;
        height: 100%;
        object-fit: cover;
      }
    }

    .content {
      display: flex;
      flex-direction: column;
      justify-content: center;
      margin-left: 12px;
      overflow: hidden;
      .tt1 {
        display: flex;
        justify-content: space-between;
        .tt2 {
          display: flex;
          justify-content: center;
          flex-direction: column;
        }
      }

      .tn {
        font-size: 20px;
        font-weight: 600;
        color: #333;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
      }

      .tt {
        font-size: 14px;
        color: #888;
      }
    }
  }

  .foot {
    display: flex;
    justify-content: space-between;
    align-items: center;
    position: absolute;
    bottom: 12px;
    left: 16px;
    right: 16px;

    .tg {
      display: flex;
      align-items: center;
      gap: 4px;
      font-size: 14px;
      color: #666;

      .tc {
        width: 16px;
        height: 16px;
        vertical-align: middle;
        fill: #ff4d4f;
        transition: transform 0.2s ease;

        &:hover {
          transform: scale(1.2);
        }
      }
    }

    .tg:nth-child(2) .tc {
      fill: #1890ff;
    }
  }
}

@media (max-width: 760px) {
  .t1 {
    width: 96%;
    height: 14vh;
    margin: 0 auto;
    padding: 12px;

    .t2 {
      .tp {
        width: 32px;
        height: 32px;
      }

      .content {
        .tn {
          font-size: 16px;
        }

        .tt {
          font-size: 12px;
        }
      }
    }

    .foot {
      bottom: 8px;
      left: 12px;
      right: 12px;

      .tg {
        font-size: 12px;
      }
    }
  }
}
</style>

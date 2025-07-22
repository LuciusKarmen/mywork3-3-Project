interface Message {
  mid: string
  mname: string //这里的mname是回复的帖子的id(tid)不然后面人看不懂
  mget: string
  msend: string
  mtime: string
  mcontent: string
  mread: boolean
  mtipid: string
}

export type { Message }

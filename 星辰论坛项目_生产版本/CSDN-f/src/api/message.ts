interface Message {
  mid: string
  mname: string //依然觉得当时把这个名字设置成发帖者的头像就觉得不知道当时是怎么想的
  mget: string
  msend: string
  mtime: string
  mcontent: string
  mread: boolean
  mtipid: string
}

export type { Message }

export interface Message {
  id: string
  from_id: string
  to_id: string
  content: string
  time: string
  read: boolean
}
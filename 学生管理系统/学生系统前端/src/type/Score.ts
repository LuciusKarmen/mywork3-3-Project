// types/Score.ts
export interface Score {
  id: string
  courseId: string
  studentId: string
  score: number // 分数（0~100）
  stair: string // 等级（如 A, B, 及格等）
}

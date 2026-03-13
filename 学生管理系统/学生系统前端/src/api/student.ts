// 选课接口：传入 { studentId, courseId }

import type { Student, StudentCourse } from '@/type'
import request from '../api/request'
import type { Course } from '../type/Course'

// 获取可选课程（建议后端只返回未选且已审核的课程）
export const queryByStudentId = (id: string) =>
  request<Course[]>({
    url: '/sc/queryByStudentId',
    method: 'GET',
    params: { id },
  })

export const selectCourse = (data: StudentCourse) =>
  request({
    url: '/sc/add',
    method: 'POST',
    data,
  })

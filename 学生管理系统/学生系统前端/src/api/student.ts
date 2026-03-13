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
  }).then((res) => console.log(res))

// 选课
export const selectCourse = (data: StudentCourse) =>
  request({
    url: '/sc/add',
    method: 'POST',
    data,
  })

export const querytable = (studentId: string) =>
  request<Course[]>({
    url: '/sc/querytable',
    method: 'GET',
    params: { studentId },
  })

// 获取可选课程（未选的）
export const queryno = (studentId: string) =>
  request<Course[]>({
    url: '/sc/queryno',
    method: 'GET',
    params: { studentId },
  })

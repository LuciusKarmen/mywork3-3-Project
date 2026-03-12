// 选课接口：传入 { studentId, courseId }

import request from '../api/request'
import type { Course } from '../type/Course'

// 获取可选课程（建议后端只返回未选且已审核的课程）
export const getAvailableCourses = () =>
  request<Course[]>({
    url: '/course/add',
    method: 'GET',
  })

export const getMyCourse = () =>
  request<Course[]>({
    url: '/course/queryByStudentId',
    method: 'GET',
  }).then((res) => console.log(res))

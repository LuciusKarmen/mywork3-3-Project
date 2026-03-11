import request from './request'
import type { Student } from '../type/Student'
import type { Teacher } from '../type/Teacher'
import type { Course } from '../type/Course'

export const addCourse = (data: Course) =>
  request<{ message: string }>({
    url: '/course/addCourse',
    method: 'POST',
    data,
  })

//根据教师id获取课程
export const getCourseByTeacherId = (id: string) =>
  request<Course[]>({
    url: '/course/queryCourseByTeacherId',
    method: 'POST',
    data: { id },
  })

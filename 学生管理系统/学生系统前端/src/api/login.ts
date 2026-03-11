import request from './request'
import type { Student } from '../type/Student'
import type { Teacher } from '../type/Teacher'
import type { Admin } from '../type/Admin'
import type { Course } from '../type/Course'

export const loginStudent = (name: string, password: string) =>
  request<Student>({
    url: '/student/login',
    method: 'post',
    params: { name, password },
  }).then((res) => {
    if (res) {
      localStorage.setItem('student', JSON.stringify(res))
    }
    return res
  })

export const loginTeacher = (name: string, password: string) =>
  request<Teacher>({
    url: '/teacher/login',
    method: 'post',
    params: { name, password },
  }).then((res) => {
    if (res) {
      localStorage.setItem('teacher', JSON.stringify(res))
    }
    return res
  })

export const loginAdmin = (name: string, password: string) =>
  request<Admin>({
    url: '/admin/login',
    method: 'post',
    params: { name, password },
  }).then((res) => {
    if (res) {
      localStorage.setItem('admin', JSON.stringify(res))
    }
    return res
  })

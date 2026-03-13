import request from './request'
import type { Student } from '../type/Student'
import type { Teacher } from '../type/Teacher'
import type { Course } from '../type/Course'
import type { Admin } from '@/type'

export const getStudentList = () => {
  return request<Student[]>({
    url: '/student/querystudentAll',
    method: 'GET',
  }).then((res) => {
    console.log(res)
    return res
  })
}
//获取所有老师
export const getTeacherList = () => {
  return request<Teacher[]>({
    url: '/teacher/queryteacherAll',
    method: 'GET',
  }).then((res) => {
    console.log(res)
    return res
  })
}

export const getAdminList = () => {
  return request<Admin[]>({
    url: '/admin/queryAdminAll',
    method: 'GET',
  }).then((res) => {
    console.log(res)
    return res
  })
}

export const getCourseList = () => {
  return request<Course[]>({
    url: '/course/queryCourseAll',
    method: 'GET',
  }).then((res) => {
    console.log(res)
    return res
  })
}

export const addStudent = (data: Student) => {
  return request({
    url: '/admin/addStudent',
    method: 'POST',
    data,
  }).then((res) => console.log(res))
}

//添加管理员
export const addAdmin = (data: Admin) => {
  return request({
    url: '/admin/addAdmin',
    method: 'POST',
    data,
  }).then((res) => console.log(res))
}

export const addTeacher = (data: Teacher) => {
  return request({
    url: '/admin/addTeacher',
    method: 'POST',
    data,
  }).then((res) => console.log(res))
}

//同意课程
export const agreeCourse = (id: string) => {
  return request({
    url: '/admin/agreeCourse',
    method: 'POST',
    params: { id: id },
  })
}

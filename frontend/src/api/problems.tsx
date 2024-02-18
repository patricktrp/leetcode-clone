import axios from 'axios'

export const getProblems = async () => {
    const res = await axios.get(`http://localhost:8080/problems`)
    return res.data
}

export const getProblemById = async (problemId: string) => {
    const res = await axios.get(`http://localhost:8080/problems/${problemId}`)
    return res.data
}
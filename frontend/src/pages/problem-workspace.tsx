import { getProblemById } from "@/api/problems"
import { useQuery } from '@tanstack/react-query'
import { useParams } from "react-router-dom"

const ProblemWorkspace = () => {
    const params = useParams()

    const { data } = useQuery({
        queryKey: ['problems', params.problemId],
        queryFn: () => getProblemById(params.problemId)
    })

    return (
        <>
            <div>{params.problemId}</div>
            <pre>{JSON.stringify(data, null, 2)}</pre>
        </>
    )
}

export default ProblemWorkspace
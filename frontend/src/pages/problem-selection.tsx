import { getProblems } from "@/api/problems"
import { useQuery } from "@tanstack/react-query"


const ProblemSelection = () => {
    const { data } = useQuery({
        queryKey: ['problems'],
        queryFn: getProblems
    })

    return (
        <>
            <pre>{JSON.stringify(data, null, 2)}</pre>
        </>
    )
}

export default ProblemSelection
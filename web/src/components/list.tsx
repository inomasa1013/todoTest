import React, {useEffect, useState} from 'react';
import "./list.scss"

function List(): any {

    const [listArray, setListArray] = useState<string[]>(["masa", "masamasa", "masasan"])
    const [inputValue, setInputValue] = useState<string>("")

    useEffect(() => {
        fetch("http://localhost:8080/todo")
            .then((res) => {
                console.log(res)
                return res.json()
            }).then(data => {
            setListArray(data)
        })

    }, [])


    function deleteElement(index: number) {
        const dummyListArray = [...listArray]
        dummyListArray.splice(index, 1)
        setListArray(dummyListArray)
    }

    function addElement(element: string) {
        if (inputValue !== "") {
            const requestBody = {
                title:element
            }
            fetch("http://localhost:8080/todo",{
                method:"POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body:JSON.stringify(requestBody)
            }).then(res=>{
               return res.json()
            }).then(data=>{
                console.log(data)
                setListArray(data)
            })
            setInputValue("")
        }
    }

    function getInput(event: React.ChangeEvent<HTMLInputElement>) {
        setInputValue(event.target.value)
    }

    return <div>
        <ul className="listBody">
            {listArray.map((name, index) => (
                <li key={index}>
                    <input type="checkbox" checked={false} onChange={() => deleteElement(index)}></input>
                    {name}
                </li>
            ))}
        </ul>
        <input type="text" value={inputValue} onChange={getInput}></input>
        <button onClick={() => addElement(inputValue)}>add</button>
    </div>
}

export default List
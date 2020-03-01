import React, { Component } from 'react';
import Button from '@material-ui/core/Button';
const axios = require('axios');
class Goals extends Component {
    state = {
        goals: [
            { id: 1, name: "Eat 5 apples", status: "done" },
            { id: 2, name: "Run 3km", status: "undone" },
            { id: 3, name: "Go to gym 3 times", status: "done" },
            { id: 4, name: "Drink glass of water before you go to work", status: "done" },
            { id: 5, name: "Do some push-ups", status: "done" },
            { id: 6, name: "Go for a walk", status: "done" },
            { id: 7, name: "Eat one vegetable", status: "done" },
        ]
    }

    componentWillMount() {
        axios.get("http://localhost:8080/api/goal/all").then(
            (response) => this.setState({ goals: response.data })
        ).catch((error) => {
            console.log(error)
        })
    }
    handleClick = id => {
        let tmp = this.state.goals.filter(goal => goal.id === id)[0];
        tmp.status = tmp.status === "done" ? "undone" : "done";
        const goals = this.state.goals.map(goal => goal.id !== id ? goal : tmp);
        this.setState({ goals });
        axios.post('http://localhost:8080/api/goal', tmp)
            .then((response) => { })
            .catch()
    }


    render() {
        return (<div>
            <ul>{this.state.goals.map(goal =>
                <li key={goal.id}>
                    <Button disableElevation variant="contained" color="primary" href="#contained-buttons" id={goal.id}
                        name={goal.name}
                        style={{
                            backgroundColor: goal.status === "done" ? "#00ff00" : "#808080",
                            borderColor: goal.status === "done" ? "#00ff00" : "#808080"
                        }} onClick={() => this.handleClick(goal.id)}>{goal.name}</Button>
                </li>)}
            </ul>
        </div>);
    }
}

export default Goals;
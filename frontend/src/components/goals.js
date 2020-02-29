import React, { Component } from 'react';

class Goals extends Component {
    state = {
        goals: [
            { id: 1, name: "Eat 5 apples", status: "done" },
            { id: 2, name: "Run 3km", status: "undone" },
            { id: 3, name: "Got o gym 3 times", status: "done" }
        ]
    }

    handleClick = id => {
        let tmp = this.state.goals.filter(goal => goal.id === id)[0];
        tmp.status = tmp.status === "done" ? "undone" : "done";
        console.log(tmp);
        const goals = this.state.goals.map(goal => goal.id !== id ? goal : tmp);
        console.log(goals);
        this.setState({ goals });
        console.log(this.state.goals[id]);
    }



    render() {
        return (<div><ul>{this.state.goals.map(goal =>
            <li key={goal.id}><button id={goal.id} name={goal.name} style={{ backgroundColor: goal.status === "done" ? "#00ff00" : "#808080" }} onClick={() => this.handleClick(goal.id)}>{goal.name}</button></li>)}
        </ul></div >);
    }
}

export default Goals;
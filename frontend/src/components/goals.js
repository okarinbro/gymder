import React, {Component} from 'react';
import Button from '@material-ui/core/Button';
import '../styles/goals.css'

const axios = require('axios');

class Goals extends Component {
    state = {
        goals: []
    }

    componentWillMount() {
        axios.get("http://localhost:8080/api/goal/all/").then(
            (response) => this.setState({goals: response.data})
        ).catch((error) => {
            console.log(error)
        })
    }

    handleClick = id => {
        let tmp = this.state.goals.filter(goal => goal.id === id)[0];
        tmp.status = tmp.status === "done" ? "undone" : "done";
        const goals = this.state.goals.map(goal => goal.id !== id ? goal : tmp);
        this.setState({goals});
        axios.post('http://localhost:8080/api/goal', tmp)
            .then((response) => {
            })
            .catch()
    }


    render() {
        return (<div>
            <h1>Goals:</h1>
            <ul style={{listStyle: "none"}}>{this.state.goals.map(goal =>
                <li key={goal.id}>
                    <Button className="goalsCellDiv" disableElevation variant="contained" color="primary"
                            href="#contained-buttons" id={goal.id}
                            name={goal.name}
                            style={{
                                backgroundColor: goal.status === "done" ? "#00ff00" : "#808080",
                                borderColor: goal.status === "done" ? "#00ff00" : "#808080"
                            }} onClick={() => this.handleClick(goal.id)}>{goal.name}</Button>
                </li>)}
            </ul>
        </div>)
            ;
    }
}

export default Goals;
import React, {Component} from 'react';
import TextField from '@material-ui/core/TextField'
import Button from '@material-ui/core/Button'

const axios = require('axios').default;

class Day extends Component {
    state = {
        water: 0,
        steps: 0,
        calories: 0
    }

    logChange = value => {
        console.log(value)
    }

    handleSubmit = (event) => {
        event.preventDefault();
        console.log(this.state);

        const requestBody = {
            steps: this.state.steps,
            calories: this.state.calories,
            water: this.state.water
        }

        axios.put("http://localhost:8080/api/report/", requestBody).then((response) => {
            if (response.status === 200) {
                console.log('Report submit succesful')
            } else {
                console.log("Report submit failed")
            }
        })
    }

    waterInputChangeHandler = (event) => {
        this.setState({water: event.target.value})
    }

    caloriesInputChangeHandler = (event) => {
        this.setState({calories: event.target.value})
    }

    stepsInputChangeHandler = (event) => {
        this.setState({steps: event.target.value})
    }

    render() {
        return (<div>
            <form onSubmit={this.handleSubmit}>My day<br/>
                <TextField id="outlined-basic" label="Water" variant="outlined"
                           onChange={this.waterInputChangeHandler}/>
                <br/>
                <TextField id="outlined-basic" label="Steps" variant="outlined"
                           onChange={this.stepsInputChangeHandler}/>
                <br/>
                <TextField id="outlined-basic" label="Calories" variant="outlined"
                           onChange={this.caloriesInputChangeHandler}/>
                <br/>
                <Button type="submit" variant="contained" color="primary"> Submit </Button>
            </form>
        </div>);
    }
}

export default Day;
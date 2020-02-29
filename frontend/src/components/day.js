import React, { Component } from 'react';

class Day extends Component {
    state = {}
    logChange = value => {
        console.log(value)
    }
    handleSubmit(event) {
        console.log(event);
        console.log(document.getElementById("waterInput").value);
        event.preventDefault();
    }
    render() {
        return (<div>
            asdf
            <form onSubmit={this.handleSubmit}>My day<br />
                <label>Water
                    <input type="text" id="waterInput" onChange={() => this.logChange(this.value)} />
                </label><br />
                <label>Steps
                    <input type="text" id="stepsInput" />
                </label><br />
                <label>Calories
                    <input type="text" id="caloriesInput" />
                </label>
                <input type="submit" value="Send" />
            </form>
        </div>);
    }
}

export default Day;
import React, { Component } from 'react';

class Day extends Component {
    state = {}
    logChange = value => {
        console.log(value)
    }
    handleSubmit(event) {
        console.log(event);
    }
    render() {
        return (<div>
            asdf
            <form onSubmit={this.handleSubmit}>My day<br />
                <label>Water
                    <input type="text" onChange={() => this.logChange(this.value)} />
                </label><br />
                <label>Steps
                    <input type="text" />
                </label><br />
                <label>Calories
                    <input type="text" />
                </label>
                <input type="submit" value="Send" />
            </form>
        </div>);
    }
}

export default Day;
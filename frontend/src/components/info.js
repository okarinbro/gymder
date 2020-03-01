import React, { Component } from 'react';
const axios = require('axios').default;

class Info extends Component {

    state = {
        info: "Info"
    }

    componentWillMount() {
        axios.get("http://localhost:8080/api/info/").then(
            (response) => this.setState({ info: response.data })
        ).catch((error) => {
            console.log(error)
        })
    }

    render() {
        return (<div>{this.state.info}</div>);
    }
}

export default Info;
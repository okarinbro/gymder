import React, {Component} from 'react';
import Typography from '@material-ui/core/Typography'

const axios = require('axios').default;

class Info extends Component {

    state = {
        info: "Info"
    }

    componentWillMount() {
        axios.get("http://localhost:8080/api/info/").then(
            (response) => this.setState({info: response.data})
        ).catch((error) => {
            console.log(error)
        })
    }

    render() {
        const textStyle = {
            color: "black",
            backgroundColor: "light_blue",
            padding: "40px",
            fontFamily: "Arial"
        };
        return (<div><Typography style={textStyle}>{this.state.info}</Typography></div>);
    }
}

export default Info;
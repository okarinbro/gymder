import React, { Component } from 'react';
import '../styles/mainContent.css';

class MainContent extends Component {
    state = {}

    render() {
        return (<div className="contentMainDiv">{this.props.context}</div>);
    }
}

export default MainContent;
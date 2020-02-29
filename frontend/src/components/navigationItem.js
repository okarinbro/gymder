import React, { Component } from 'react';
import '../styles/navigationItem.css'

class NavigationItem extends Component {
    state = {}
    handleClick(context) {
        this.props.handleClick(context);
    }
    render() {
        return (<button className="navigationItemButton" onClick={() => this.handleClick(this.props.name)}>{this.props.name}</button>);
    }
}

export default NavigationItem;
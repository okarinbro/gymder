import React, { Component } from 'react';

class NavigationItem extends Component {
    state = {}
    render() {
        return (<span>{this.props.name}</span>);
    }
}

export default NavigationItem;
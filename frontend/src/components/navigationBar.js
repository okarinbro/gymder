import React, { Component } from 'react';
import NavigationItem from './navigationItem';
import '../styles/navigationBar.css';
import Gymder from './gymder';

class NavigationBar extends Component {
    state = {
        items: [
            { id: 1, name: "Info" },
            { id: 2, name: "Your day" },
            { id: 3, name: "Goals" },
            { id: 4, name: "Friends" },
            { id: 5, name: "Gymder" }
        ]
    }
    /*handleContextChange(context) {
        this.props.handleContextChange(context);
    }*/
    render() {
        return (<div className="navigationMainDiv">
            {this.state.items.map(item => <div key={item.id}><NavigationItem name={item.name} handleClick={this.props.handleContextChange} /></div>)}
        </div>);
    }
}

export default NavigationBar;
import React, { Component } from 'react';
import './App.css';
import Main from './components';
import Login from './components/Login';
import { HashRouter, Switch, Route } from 'react-router-dom';

class App extends Component {
  render() {
    return (
      <div className="App">
          <HashRouter basename="/" >
              <Switch>
                  <Route path="/login" exact component={Login}></Route>
                  <Route path="/" component={Main} />
              </Switch>
          </HashRouter>
      </div>
    );
  }
}

export default App;

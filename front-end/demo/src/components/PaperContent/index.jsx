import React, { Component } from 'react';
import QuestionItem from './questionItem'
import { Button, Popover } from 'antd'

import './index.css'

class PaperContent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      paperName: '',
      popupVisible: false,
      questionList: [],
      isPreview: false,
      totalPoints: null,
      userAnwsers: []
    };
  }

  componentDidMount() {
    // Fetch data
    // get /papers/{paperId}
    const mockData = { "paperName": "Test paper", "itemBeanList": [{ "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 1, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }, { "itemId": 2, "points": 5, "description": "jiojiwda", "optionA": "hui", "optionB": "da", "optionC": "dawdw", "optionD": "dwa" }] }

    const paperId = this.props.match.params.id
    let userAnwsers = []

    fetch(`/exam/papers/${paperId}`, {
      method: 'GET'
    })
      .then(res => {
        return res.json()
      })
      .then(res => {
        console.log(res)
        const questionList = res.itemBeanList.map((e, i) => {
          userAnwsers[i] = ''
          return {
            itemId: res.id,
            description: e.description,
            points: e.points,
            anwsers: [e.optionA, e.optionB, e.optionC, e.optionD],
            correctIndex: 2
          }
        })
        this.setState({
          paperName: res.paperName,
          questionList,
          userAnwsers
        })
      })
  }

  handleVisibleChange = (popupVisible) => {
    this.setState({ popupVisible });
  }

  handleSubmit = () => {
    this.setState({
      popupVisible: false,
      isPreview: true,
      totalPoints: 100
    })
    // Fetch data
  }

  selectOption = (value, index) => {
    let userAnwsers = this.state.userAnwsers
    userAnwsers[index] = value
    this.setState({
      userAnwsers
    })
  }

  render() {
    const { paperName, questionList, isPreview, totalPoints } = this.state

    return (
      <div className='paper-content'>
        <div className='paper-background'>
          <h1 className="paper-title">{paperName}</h1>
          {totalPoints && <h2 className="total-points">{`总分: ${totalPoints}分`}</h2>}
          {
            questionList.map((e, i) => (
              <QuestionItem
                key={i}
                index={i}
                description={e.description}
                points={e.points}
                anwsers={e.anwsers}
                isPreview={isPreview}
                correctIndex={e.correctIndex}
                selectOption={this.selectOption}
              />
            ))
          }
          <Popover
            content={<a onClick={this.handleSubmit}>确定！</a>}
            title="确定提交？"
            trigger="click"
            visible={this.state.popupVisible}
            onVisibleChange={this.handleVisibleChange}
          >
            <Button className={isPreview ? 'hidden' : ''} type="primary">提交答卷</Button>
          </Popover>
        </div>
      </div>
    );
  }
}

export default PaperContent;
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
        };
    }

    componentDidMount () {
      // Fetch data
      // get /papers/{paperId}
        const mockData = {"paperName":"dsa","itemBeanList":[{"itemId":1,"points":5,"description":"jiojiwda","optionA":"hui","optionB":"da","optionC":"dawdw","optionD":"dwa"},{"itemId":2,"points":5,"description":"jiojiwda","optionA":"hui","optionB":"da","optionC":"dawdw","optionD":"dwa"}]}
        const questionList = mockData.itemBeanList.map((e) => {
          return {
            itemId: e.itemId,
            description: e.description,
            points: e.points,
            anwsers: [e.optionA, e.optionB, e.optionC, e.optionD]
          }
        })

        this.setState({
          paperName: '语文',
          questionList
        })
    }

    handleVisibleChange = (popupVisible) => {
      this.setState({ popupVisible });
    }

    handleSubmit = () => {
      this.setState({
        popupVisible: false,
        isPreview: true
      })
      // Fetch data
    }

    render() {
      const { paperName, questionList, isPreview, totalPoints } = this.state

        return (
            <div className='paper-content'>
                <h1 className="paper-title">{paperName}</h1>
                { totalPoints && <h2 className="total-points">{`总分: ${totalPoints}分`}</h2> }
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
        );
    }
}

export default PaperContent;
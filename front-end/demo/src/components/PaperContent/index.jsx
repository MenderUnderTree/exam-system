import React, { Component } from 'react';
import QuestionItem from './questionItem'
import { Button } from 'antd'

class PaperContent extends Component {
    constructor(props) {
        super(props);
        this.state = {
          paperName: '',
          confirmPop: false,
          questionList: [],
          isPreview: false
        };
    }

    componentDidMount () {
        this.setState({
          paperName: '语文',
          questionList: [
            {
              id:1,
              description: '题目题目题目题目题目题目题目题目题目题目',
              points: '50',
              anwsers: ['非常好', '好', '一般', '不好']
            },
            {
              id:2,
              description: '题目题目题目题目题目题目题目题目题目题目',
              points: '50',
              anwsers: ['非常好', '好', '一般', '不好']
            }
          ]
        })
    }

    render() {
      const { paperName, questionList, isPreview } = this.state

        return (
            <div className='paper-content'>
                <h1 className="paper-title">{paperName}</h1>
                {
                  questionList.map((e, i) => (
                    <QuestionItem 
                      key={i}
                      index={i}
                      description={e.description}
                      points={e.points}
                      anwsers={e.anwsers}
                      ispreview={isPreview}
                    />
                  ))
                }
                <Button type="primary">提交答卷</Button>
            </div>
        );
    }
}

export default PaperContent;
import React, { Component } from 'react';
import { Radio } from 'antd'

const RadioGroup = Radio.Group;

class QuestionItem extends Component {
  constructor(props) {
    super(props)

    this.state = {
      selectedValue: null
    }
  }

  _onRadioChange (e) {
    this.setState({
      selectedValue: e.target.value
    })
  }

    render() {
      const { index, description, points, ispreview, anwsers } = this.props
      const anwserOptions = anwsers.map((e, i) => {
        return {
          label: `${String.fromCharCode(i+97)}. ${e}`,
          value: i, 
          disabled: ispreview
        }
      })

        return (
            <div className='question-item'>
                <label className='question-title'>{`${index+1}. ${description} (${points}分)`}</label>
                { ispreview && 
                  <p className='corret-anwser'>
                    { `回答正确 回答错误 正确答案是` }
                  </p> 
                }
                <RadioGroup options={anwserOptions} onChange={(e) => this._onRadioChange(e)} value={this.state.selectedValue}/>
            </div>
        );
    }
}

export default QuestionItem;
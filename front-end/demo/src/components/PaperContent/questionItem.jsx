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

  _onRadioChange(e, index) {
    this.setState({
      selectedValue: e.target.value
    })
    this.props.selectOption(e.target.value, index)
  }

  render() {
    const { index, description, points, isPreview, anwsers, correctIndex } = this.props
    const { selectedValue } = this.state

    const anwserOptions = anwsers.map((e, i) => {
      return {
        label: `${String.fromCharCode(i + 97)}. ${e}`,
        value: i,
        disabled: isPreview
      }
    })

    return (
      <div className='question-item'>
        <label className='question-title'>{`${index + 1}. ${description} (${points}分)`}</label>
        {isPreview &&
          <p className='corret-anwser'>
            {correctIndex === selectedValue ? <span className='answer-correct'>回答正确</span> : <span className='answer-wrong'>回答错误 正确答案为 {String.fromCharCode(correctIndex + 97)}</span>}
          </p>
        }
        <RadioGroup options={anwserOptions} onChange={(e) => this._onRadioChange(e, index)} value={this.state.selectedValue} />
      </div>
    );
  }
}

export default QuestionItem;
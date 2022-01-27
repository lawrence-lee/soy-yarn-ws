import 'dynamic-data-mapping-form-field-type/FieldBase/FieldBase.es';
import './my-soy-formRegister.soy.js';
import templates from './my-soy-form.soy.js';
import {Config} from 'metal-state';


/**
 * MySoyForm Component
 */
class MySoyForm extends Component {

	dispatchEvent(event, name, value) {
		this.emit(name, {
			fieldInstance: this,
			originalEvent: event,
			value
		});
	}

	_handleFieldChanged(event) {
		const {value} = event.target;

		this.setState(
			{
				value
			},
			() => this.dispatchEvent(event, 'fieldEdited', value)
		);
	}
}

MySoyForm.STATE = {

	name: Config.string().required(),

	predefinedValue: Config.oneOfType([Config.number(), Config.string()]),

	required: Config.bool().value(false),

	showLabel: Config.bool().value(true),

	spritemap: Config.string(),

	value: Config.string().value('')
}

// Register component
Soy.register(MySoyForm, templates);


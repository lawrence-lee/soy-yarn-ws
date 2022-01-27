package my.soy.form.form.field;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author lawrence
 */
@Component(
	immediate = true,
	property = {
		"ddm.form.field.type.description=my-soy-form-description",
		"ddm.form.field.type.display.order:Integer=13",
		"ddm.form.field.type.group=customized",
		"ddm.form.field.type.icon=text",
		"ddm.form.field.type.label=my-soy-form-label",
		"ddm.form.field.type.name=mySoyForm"
	},
	service = DDMFormFieldType.class
)
public class MySoyFormDDMFormFieldType extends BaseDDMFormFieldType {

	@Override
	public String getModuleName() {
		return _npmResolver.resolveModuleName(
			"dynamic-data-my-soy-form-form-field/my-soy-form.es");
	}

	@Override
	public String getName() {
		return "mySoyForm";
	}

	@Override
	public boolean isCustomDDMFormFieldType() {
		return true;
	}

	@Reference
	private NPMResolver _npmResolver;

}
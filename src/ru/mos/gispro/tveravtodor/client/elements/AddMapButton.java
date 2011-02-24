package ru.mos.gispro.tveravtodor.client.elements;

import com.google.gwt.user.client.*;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.events.CloseClientEvent;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.FormItemIfFunction;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.widgets.tree.Tree;
import com.smartgwt.client.widgets.tree.TreeGrid;
import ru.mos.gispro.tveravtodor.client.layer.LayerUtils;

/**
 * User: dima
 * Date: 20.11.2010
 * Time: 15:14:55
 */

public class AddMapButton extends ToolStripButton {

	public static final String SERVICE_ARCGIS93 = "ArcGIS";
	public static final String SERVICE_WMS = "WMS";


	public AddMapButton(final TreeGrid treeGrid) {

		final Tree data = treeGrid.getTree();

		this.setIcon("MActionAddMap.png");
		this.setIconSize(20);
		this.setHeight(30);
		this.setTitle("Добавить");
		this.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				final Dialog winModal = new Dialog();
				winModal.setTitle("Добавление ГИС сервиса");
				winModal.setAutoSize(true);
				winModal.setCanDragResize(true);
				winModal.setIsModal(true);
				winModal.addCloseClickHandler(new CloseClickHandler() {
					public void onCloseClick(CloseClientEvent event) {
						winModal.destroy();
					}
				});
				final DynamicForm form = new DynamicForm();
				form.setHeight100();
				form.setWidth100();
				form.setMargin(10);
				form.setColWidths("100px","200px");


				final TextItem name = new TextItem();
				name.setTitle("Название");
				name.setRequired(true);
				name.setRequiredMessage("Поле обязательно для заполнения");
				name.setValue("");

				final ComboBoxItem serviceType = new ComboBoxItem("Тип");
				serviceType.setValueMap(SERVICE_ARCGIS93, SERVICE_WMS);
				serviceType.setRequired(true);
				serviceType.setRequiredMessage("Поле обязательно для заполнения");
				serviceType.setDisabled(false);
				serviceType.setRedrawOnChange(true);

				final TextItem layerName = new TextItem();
				layerName.setTitle("Слой");
				layerName.setRequired(true);
				layerName.setRequiredMessage("Поле обязательно для заполнения");
				layerName.setValue("");
				layerName.setVisible(false);
				layerName.setShowIfCondition(new FormItemIfFunction() {
					public boolean execute(FormItem formItem, Object o, DynamicForm dynamicForm) {
						return SERVICE_WMS.equals(serviceType.getValue()); 
					}
				});

				serviceType.addChangedHandler(new ChangedHandler() {
					public void onChanged(ChangedEvent changedEvent) {
						if (SERVICE_ARCGIS93.equals(serviceType.getValue())) {
							layerName.setRequired(false);
							return;
						}
						if (SERVICE_WMS.equals(serviceType.getValue())) {
							layerName.setRequired(true);
						}
					}
				});

				final TextItem url = new TextItem();
				url.setTitle("Адрес");
				url.setValue("");
				url.setWidth(400);
				url.setRequired(true);
				url.setRequiredMessage("Поле обязательно для заполнения");

				form.setFields(name, serviceType, url, layerName);
				winModal.addItem(form);

				Button btnClose = new Button("Подключить");
				btnClose.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {

						if (!form.validate()) {
							return;
						}

						if (SERVICE_ARCGIS93.equals(serviceType.getValue())) {
							LayerUtils.addArcGIS93Layer(name.getValue().toString(), url.getValue().toString(), treeGrid, true);
						}

						if (SERVICE_WMS.equals(serviceType.getValue())) {
							LayerUtils.addWMSLayer(name.getValue().toString(), url.getValue().toString(), layerName.getValue().toString(), treeGrid, true);
						}

						LayerUtils.initLayerOrder(treeGrid);

						winModal.hide();
					}
				});

				winModal.setToolbarButtons(btnClose);
				winModal.show();
			}
		});

	}


}

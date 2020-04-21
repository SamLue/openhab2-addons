/**
 * Copyright (c) 2010-2020 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.victronenergydbus.internal;

import java.util.Map;

import org.freedesktop.dbus.annotations.DBusInterfaceName;
import org.freedesktop.dbus.exceptions.DBusException;
import org.freedesktop.dbus.interfaces.DBusInterface;
import org.freedesktop.dbus.messages.DBusSignal;
import org.freedesktop.dbus.types.Variant;

/**
 * The {@link VictronEnergyDBusHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author Samuel Lueckoff - Initial contribution
 */

@DBusInterfaceName("com.victronenergy.BusItem")
public interface BusItem extends DBusInterface {
    public static class PropertiesChanged extends DBusSignal {
        public final Map<String, Variant> changes;

        public PropertiesChanged(String path, Map<String, Variant> changes) throws DBusException {
            super(path, changes);
            this.changes = changes;
        }
    }

    public String GetDescription(String language, int length);

    public Variant GetValue();

    public String GetText();

    public int SetValue(Variant value);

    public Variant GetMin();

    public Variant GetMax();

    public int SetDefault();

    public Variant GetDefault();

}

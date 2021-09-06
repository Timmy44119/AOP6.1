/*
 * Axelor Business Solutions
 *
 * Copyright (C) 2021 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.account.service.move;

import com.axelor.apps.account.db.Journal;
import com.axelor.apps.account.db.Move;
import com.axelor.apps.account.db.PaymentMode;
import com.axelor.apps.account.db.PaymentVoucher;
import com.axelor.apps.base.db.Company;
import com.axelor.apps.base.db.Currency;
import com.axelor.apps.base.db.Partner;
import com.axelor.exception.AxelorException;
import java.time.LocalDate;

public interface MoveCreateService {

  /**
   * Créer une écriture comptable à la date du jour impactant la compta.
   *
   * @param journal
   * @param period
   * @param company
   * @param invoice
   * @param partner
   * @param isReject <code>true = écriture de rejet avec séquence spécifique</code>
   * @return
   * @throws AxelorException
   */
  public Move createMove(
      Journal journal,
      Company company,
      Currency currency,
      Partner partner,
      PaymentMode paymentMode,
      int technicalOriginSelect,
      int functionalOriginSelect,
      String origin,
      String description)
      throws AxelorException;

  /**
   * create an account move
   *
   * @param journal
   * @param company
   * @param currency
   * @param partner
   * @param date
   * @param paymentMode
   * @param technicalOriginSelect
   * @return
   * @throws AxelorException
   */
  public Move createMove(
      Journal journal,
      Company company,
      Currency currency,
      Partner partner,
      LocalDate date,
      PaymentMode paymentMode,
      int technicalOriginSelect,
      int functionalOriginSelect,
      String origin,
      String description)
      throws AxelorException;

  /**
   * Creating a new generic accounting move
   *
   * @param journal
   * @param company
   * @param currency
   * @param partner
   * @param date
   * @param paymentMode
   * @param technicalOriginSelect
   * @param ignoreInDebtRecoveryOk
   * @param ignoreInAccountingOk
   * @return
   * @throws AxelorException
   */
  public Move createMove(
      Journal journal,
      Company company,
      Currency currency,
      Partner partner,
      LocalDate date,
      PaymentMode paymentMode,
      int technicalOriginSelect,
      int functionalOriginSelect,
      boolean ignoreInDebtRecoveryOk,
      boolean ignoreInAccountingOk,
      boolean autoYearClosureMove,
      String origin,
      String description)
      throws AxelorException;

  /**
   * Créer une écriture comptable de toute pièce spécifique à une saisie paiement.
   *
   * @param journal
   * @param period
   * @param company
   * @param invoice
   * @param partner
   * @param isReject <code>true = écriture de rejet avec séquence spécifique</code>
   * @param agency L'agence dans laquelle s'effectue le paiement
   * @return
   * @throws AxelorException
   */
  public Move createMoveWithPaymentVoucher(
      Journal journal,
      Company company,
      PaymentVoucher paymentVoucher,
      Partner partner,
      LocalDate date,
      PaymentMode paymentMode,
      int technicalOriginSelect,
      int functionalOriginSelect,
      String origin,
      String description)
      throws AxelorException;
}

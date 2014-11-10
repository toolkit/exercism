(ns bank-account)

(defrecord BankAccount [balance])

(defn open-account []
  (BankAccount. (atom 0)))

(defn update-balance [account amount]
  (let [balance (get-in account [:balance])]
    (swap! balance + amount)))

(defn get-balance [account]
  @(get-in account [:balance]))

(defn close-account [account]
  nil)

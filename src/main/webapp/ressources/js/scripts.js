document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('creditForm');
    const step1Content = document.getElementById('step1-content');
    const step2Content = document.getElementById('step2-content');
    const step3Content = document.getElementById('step3-content');
    const step1 = document.getElementById('step1');
    const step2 = document.getElementById('step2');
    const step3 = document.getElementById('step3');
    const continueStep1 = document.getElementById('continueStep1');
    const continueStep2 = document.getElementById('continueStep2');
    const showSummary = document.getElementById('showSummary');
    const submitButton = document.querySelector('button[type="submit"]');

    const amountSlider = document.getElementById('amount');
    const amountOutput = document.getElementById('amount-output');
    const durationSlider = document.getElementById('duration');
    const durationOutput = document.getElementById('duration-output');
    const monthlyInput = document.getElementById('monthly');
    const summary = document.querySelector('.summary');
    const progressBar = document.querySelector('.progress-bar');

    function updateSliderOutput(slider, output, unit) {
        output.textContent = slider.value + ' ' + unit;
        output.style.left = (slider.value - slider.min) / (slider.max - slider.min) * 100 + '%';
    }

    amountSlider.addEventListener('input', function() {
        updateSliderOutput(this, amountOutput, 'DH');
        calculateMonthly();
    });

    durationSlider.addEventListener('input', function() {
        updateSliderOutput(this, durationOutput, 'mois');
        calculateMonthly();
    });

    function calculateMonthly() {
        const amount = parseFloat(amountSlider.value);
        const duration = parseInt(durationSlider.value);
        const interestRate = 0.1; // 10% annual interest rate (example)
        const monthlyRate = interestRate / 12;
        const monthly = (amount * monthlyRate * Math.pow(1 + monthlyRate, duration)) / (Math.pow(1 + monthlyRate, duration) - 1);
        monthlyInput.value = monthly.toFixed(2);
        updateSummary();
    }

    function updateSummary() {
        document.getElementById('summaryProject').textContent = document.getElementById('project').value || 'Prêt Personnel';
        document.getElementById('summaryEmail').textContent = document.getElementById('email').value || '-';
        document.getElementById('summaryPhone').textContent = document.getElementById('phone').value || '-';
        document.getElementById('summaryStatus').textContent = document.getElementById('status').value || '-';
        document.getElementById('summaryAmount').textContent = amountSlider.value + ' DH';
        document.getElementById('summaryDuration').textContent = durationSlider.value + ' mois';
        document.getElementById('summaryMonthly').textContent = monthlyInput.value + ' DH';
        document.getElementById('summaryFees').textContent = '165,00 DH';

        // Add new fields to summary
        const civilite = document.querySelector('input[name="civilite"]:checked');
        document.getElementById('summaryCivilite').textContent = civilite ? civilite.value : '-';
        document.getElementById('summaryNom').textContent = document.getElementById('nom').value || '-';
        document.getElementById('summaryPrenom').textContent = document.getElementById('prenom').value || '-';
        document.getElementById('summaryCIN').textContent = document.getElementById('cin').value || '-';
        document.getElementById('summaryBirthdate').textContent = document.getElementById('birthdate').value || '-';
        document.getElementById('summaryEmploymentDate').textContent = document.getElementById('employmentDate').value || '-';
        document.getElementById('summaryIncome').textContent = document.getElementById('income').value ? document.getElementById('income').value + ' DH' : '-';
        const credit = document.querySelector('input[name="credit"]:checked');
        document.getElementById('summaryCredit').textContent = credit ? credit.value : '-';

        updateProgressBar();
    }

    function updateProgressBar() {
        let progress = 0;
        if (step1.classList.contains('active')) progress = 33;
        if (step2.classList.contains('active')) progress = 66;
        if (step3.classList.contains('active')) progress = 100;

        progressBar.style.width = progress + '%';
        
        if (progress > 0) {
            summary.classList.add('active');
        } else {
            summary.classList.remove('active');
        }
    }

    continueStep1.addEventListener('click', function() {
        step1Content.style.display = 'none';
        step2Content.style.display = 'block';
        step1.classList.remove('active');
        step2.classList.add('active');
        updateProgressBar();
    });

    continueStep2.addEventListener('click', function() {
        step2Content.style.display = 'none';
        step3Content.style.display = 'block';
        step2.classList.remove('active');
        step3.classList.add('active');
        updateProgressBar();
    });

    showSummary.addEventListener('click', function() {
        updateSummary();
        summary.scrollIntoView({ behavior: 'smooth' });
    });

    submitButton.addEventListener('click', function(e) {
        e.preventDefault();
        if (form.checkValidity()) {
            updateSummary();
            alert('Votre demande de crédit a été soumise avec succès!');
        } else {
            form.reportValidity();
        }
    });

    // Add input masking for better user experience
    const cinInput = document.getElementById('cin');
    cinInput.addEventListener('input', function(e) {
        let x = e.target.value.replace(/\D/g, '').match(/(\d{0,2})(\d{0,6})(\d{0,3})/);
        e.target.value = !x[2] ? x[1] : x[1] + ' ' + x[2] + (x[3] ? ' ' + x[3] : '');
    });

    const phoneInput = document.getElementById('phone');
    phoneInput.addEventListener('input', function(e) {
        let x = e.target.value.replace(/\D/g, '').match(/(\d{0,2})(\d{0,3})(\d{0,2})(\d{0,2})/);
        e.target.value = !x[2] ? x[1] : '(' + x[1] + ') ' + x[2] + (x[3] ? '-' + x[3] : '') + (x[4] ? '-' + x[4] : '');
    });

    // Initial calculations and summary update
    calculateMonthly();
    updateSummary();

    // Add event listeners to all form inputs for real-time summary updates
    form.querySelectorAll('input, select').forEach(input => {
        input.addEventListener('change', updateSummary);
    });
});